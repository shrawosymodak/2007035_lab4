    interface TV { // bridg and factory.roll 2007035
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int volume);
    int getChannel();
    void setChannel(int channel);
}

class SmartTV implements TV {
    private boolean powerOn = false;
    private int volume = 50;
    private int channel = 10;

    public boolean isEnabled() { return powerOn; }

    public void enable() { powerOn = true; }

     public void disable() { powerOn = false; }

    public int getVolume() { return volume; }

    public void setVolume(int volume) { this.volume = volume; }

    public int getChannel() { return channel; }

    public void setChannel(int channel) { this.channel = channel; }

    public void Youtube() { System.out.println("SmartTV: Showing Youtube"); }
}

class GeneralTV implements TV {
    private boolean powerOn = false;
    private int volume = 10;
    private int channel = 2;

    public boolean isEnabled() { return powerOn; }

    public void enable() { powerOn = true; }

    public void disable() { powerOn = false; }

    public int getVolume() { return volume; }

    public void setVolume(int volume) { this.volume = volume; }

    public int getChannel() { return channel; }

    public void setChannel(int channel) { this.channel = channel; }
}

abstract class Remote {
    protected TV tv;

    Remote(TV tv) { this.tv = tv; }

    public abstract void togglePower();
     public abstract void volumeUp();
    public abstract void volumeDown();
 public abstract void channelUp();
    public abstract void channelDown();
}

class GeneralRemote extends Remote {

    GeneralRemote(TV tv) { super(tv); }

    public void togglePower() {
        if (tv.isEnabled()) {
            tv.disable();
            System.out.println("Power turned off");
        } else {
            tv.enable();
            System.out.println("Power turned on");
        }
    }

    public void volumeUp() {
        if (tv.isEnabled()) {
            tv.setVolume(tv.getVolume() + 10);
            System.out.println("Volume increased by 10");
        } else {
            System.out.println("Please turn on the TV first");
        }
    }

    public void volumeDown() 
    {
        if (tv.isEnabled())
         {
            tv.setVolume(tv.getVolume() - 10);
            System.out.println("Volume decreased by 10");
        } else {
     System.out.println("Please turn on the TV first");
        }
    }

    public void channelUp()
     {
        if (tv.isEnabled()) {
            tv.setChannel(tv.getChannel() + 5);
            System.out.println("Channel increased by 5");
        } else {
            System.out.println("Please turn on the TV first");
        }
    }

    public void channelDown() {
        if (tv.isEnabled()) {
     tv.setChannel(tv.getChannel() - 5);
            System.out.println("Channel decreased by 5");
        } else {
            System.out.println("Please turn on the TV first");
        }
    }
}

class SmartRemote extends Remote {

    SmartRemote(TV tv) { super(tv); }

    public void togglePower() {
          if (tv.isEnabled()) {
        tv.disable();
            System.out.println("Power turned off");
        } else {
            tv.enable();
            System.out.println("Power turned on");
        }
    }

    public void volumeUp() {
if (tv.isEnabled()) {
            tv.setVolume(tv.getVolume() + 10);
            System.out.println("Volume increased by 10");
        } else {
            System.out.println("Please turn on the TV first");
        }
    }

    public void volumeDown() {
        if (tv.isEnabled()) {
            tv.setVolume(tv.getVolume() - 10);
            System.out.println("Volume decreased by 10");
        else {
            System.out.println("Please turn on the TV first");
        }
    }

    public void channelUp() {
        if (tv.isEnabled()) {
            tv.setChannel(tv.getChannel() + 5);
            System.out.println("Channel increased by 5");
        } else {
            System.out.println("Please turn on the TV first");
        }
    }

    public void channelDown() {
        if (tv.isEnabled()) {
            tv.setChannel(tv.getChannel() - 5);
            System.out.println("Channel decreased by 5");
        } else {
            System.out.println("Please turn on the TV first");
        }
    }

void showYoutube() { ((SmartTV) tv).Youtube(); }
}

class TVFactory {
    private static final TV smartTV = new SmartTV();
    private static final TV generalTV = new GeneralTV();

    public static TV getSmartTV() { return smartTV; }

    public static TV getGeneralTV() { return generalTV; }
}

public class Main {
    public static void main(String[] args) {

        TV generaltv = TVFactory.getGeneralTV();
        TV smarttv = TVFactory.getSmartTV();

        Remote generalRemote = new GeneralRemote(generaltv);
        generalRemote.togglePower();
        generalRemote.volumeUp();
        generalRemote.channelUp();
          generalRemote.channelDown();
            generalRemote.volumeDown();
        SmartRemote smartRemote = new SmartRemote(smarttv);
        smartRemote.togglePower();
        smartRemote.volumeUp();
        smartRemote.channelUp();
          smartRemote.channelDown();
        smartRemote.volumeDown();
        smartRemote.showYoutube();
    }
}
