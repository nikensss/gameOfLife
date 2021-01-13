package life;

public enum LifeState {
    ALIVE("O"), DEAD(" ");

    private final String lifeState;

    LifeState(String lifeState){
        this.lifeState = lifeState;
    }

    @Override
    public String toString(){
        return lifeState;
    }
}
