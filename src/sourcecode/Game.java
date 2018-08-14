package sourcecode;

public class Game {
	public int score() {
		return scoreForFrame(getCurrentFrame() - 1);
	}

	public void add(int pins) {
		itsThrows[itsCurrentThrow++] = pins;
		itsScore += pins;
		this.adjustCurrentFrame(pins);
	}

	private void adjustCurrentFrame(int pins) {
		if(firstThrowInFrame) {
			if(pin == 10)
				itsCurrentFrame++
			else
				firstThrowInFrame = false;
		}else {
			firstThrowInFrame = true;
			itsCurrentFrame++;
		}
		itsCurrentFrame = Math.min(11, itsCurrentFrame);
	}

	public int scoreForFrame(int theFrame) {
		ball = 0;
		int score = 0;
		for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
			int firstThrow = itsThrows[ball++];
			if (firstThrow == 10) {
				score += 10 + itsThrows[ball] + itsThrows[ball + 1];
			} else {
				int secondThrow = itsThrows[ball++];

				int frameScore = firstThrow + secondThrow;

				// spare needs next frames first throw
				if (frameScore == 10)
					score += frameScore + itsThrows[ball];
				else {
					score += frameScore;
				}
			}
		}
		return score;
	}

	public int getCurrentFrame() {
		return itsCurrentFrame;
	}

	private int ball;
	private int itsScore = 0;
	private int[] itsThrows = new int[21];
	private int itsCurrentThrow = 0;
	private int itsCurrentFrame = 1;
	private boolean firstThrow = true;

}