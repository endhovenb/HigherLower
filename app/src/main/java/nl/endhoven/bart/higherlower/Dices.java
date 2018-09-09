package nl.endhoven.bart.higherlower;

public class Dices {
    private String mDiceText;

    public String getmDiceText() {
        return mDiceText;
    }

    public void setmDiceText(String mDiceText) {
        this.mDiceText = mDiceText;
    }

    @Override
    public String toString() {
        return "Throw is " + mDiceText;
    }
}

