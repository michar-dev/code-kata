package tdd.exercises.jul.thirtieth;

public final class BowlingGameKata {
    private static final int NUMBER_OF_PINS = 10;
    private static final int NUMBER_OF_FRAMES = 10;

    private int currentFrameIndex = 0;
    private final Frame[] frames = new Frame[11];

    public BowlingGameKata() {
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame();
        }
    }

    public int getScoreFromFrame(final int frameIndex) {
        final Frame frame = frames[frameIndex];

        if (frame.onFirstRoll) {
            return -1;
        }

        if (frame.hasSpare()) {
            final Frame nextFrame = frames[frameIndex + 1];
            return NUMBER_OF_PINS + nextFrame.firstRollScore;
        }

        if (frame.hasStrike()) {
            final Frame nextFrame = frames[frameIndex + 1];
            return NUMBER_OF_PINS + nextFrame.firstRollScore + nextFrame.secondRollScore;
        }

        return frame.score();
    }

    public void roll(final int score) {
        final Frame currentFrame = frames[currentFrameIndex];

        currentFrame.record(score);

        if (currentFrame.completed) {
            currentFrameIndex++;
        }
    }

    public boolean canRoll() {
        if (currentFrameIndex + 1 < NUMBER_OF_FRAMES) {
            return true;
        }

        final Frame lastFrame = frames[NUMBER_OF_FRAMES - 1];
        final Frame extraFrame = frames[10];
        return (lastFrame.hasSpare() && extraFrame.onFirstRoll)
                || (lastFrame.hasStrike() && !extraFrame.completed);
    }

    private static final class Frame {
        private int firstRollScore = 0;
        private int secondRollScore = 0;
        private boolean onFirstRoll = true;
        private boolean completed = false;

        private void record(final int score) {
            if (onFirstRoll) {
                firstRollScore = score;
                onFirstRoll = false;
                completed = score == NUMBER_OF_PINS;
            } else {
                secondRollScore = score;
                completed = true;
            }
        }

        private int score() {
            return firstRollScore + secondRollScore;
        }

        private boolean hasSpare() {
            return score() == NUMBER_OF_PINS && secondRollScore > 0;
        }

        private boolean hasStrike() {
            return score() == NUMBER_OF_PINS && secondRollScore == 0;
        }
    }
}
