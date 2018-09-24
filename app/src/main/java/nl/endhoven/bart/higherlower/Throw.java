package nl.endhoven.bart.higherlower;

public class Throw {
    private int mDiceText;

    public Throw(int sDice){this.mDiceText = sDice;}

    public String getmDiceText() {
        return "" + mDiceText;
    }

    public void setmDiceText(int mDiceText) {
        this.mDiceText = mDiceText;
    }

    @Override
    public String toString() {
        return "Throw is " + mDiceText;
    }
}
