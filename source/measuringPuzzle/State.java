package measuringPuzzle;

class State {

    int totalVolume;

    int maxMeasurable;

    int[] cups = new int[3];

    State(int b1, int b2, int b3) {
        this.cups[0] = b1;
        this.cups[1] = b2;
        this.cups[2] = b3;

        this.totalVolume = b1 + b2 + b3;

        this.maxMeasurable = b1 < b2 ? (Math.max(b2, b3)) : (Math.max(b1, b3));

    }

    public State transfer(int from, int to, State maxCapacity) {

        if (this.cups[from] == 0) {
            return null;
        }
        if (this.cups[to] == maxCapacity.cups[to]) {
            return null;
        }

        State resultState = new State(this.cups[0], this.cups[1], this.cups[2]);

        resultState.cups[to] += resultState.cups[from];
        resultState.cups[from] = 0;

        if (resultState.cups[to] > maxCapacity.cups[to]) {
            int rem = resultState.cups[to] - maxCapacity.cups[to];
            resultState.cups[to] = maxCapacity.cups[to];
            resultState.cups[from] += rem;
        }

        return resultState;
    }

    public boolean has(int num) {
        for (int i = 0; i < 3; i++) {
            if (num == cups[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.cups[0] + " " + this.cups[1] + " " + this.cups[2];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof State) {
            State s = (State) obj;
            return s.cups[0] == this.cups[0] && s.cups[1] == this.cups[1] && s.cups[2] == this.cups[2];
        }
        return false;
    }

}
