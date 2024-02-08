// 2007035
//i have completed this code using bridge design pattern
interface TV {
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
    public boolean isEnabled() {
        return powerOn;
    }
    public void enable() {
        powerOn = true;
    }
    public void disable() {
        powerOn = false;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return volume;}
           
    public void setChannel(int channel) {
        this.channel = channel;
    }
    
    public int getChannel() {
        return channel;
    }

    public void Youtube() {
        System.out.println(" Showing Youtube");
    }
}

class GeneralTV implements TV {
    private boolean powerOn = false;
    private int volume = 10;
    private int channel = 2;

    
    public boolean isEnabled() {
        return powerOn;
    }
    public void enable() {
        powerOn = true;
     }
    public void disable() {
        powerOn = false;
 }
   public void setVolume(int volume) {
    this.volume = volume;
}

    public int getVolume() {
        return volume;
    }
    public void setChannel(int channel) {
        this.channel = channel;
    }
   
    public int getChannel() {
        return channel;
    }
   
}

abstract class Remote {
    protected TV tv;

    Remote(TV tv) {
        this.tv = tv;
    }

    public void togglePower() {
        if (tv.isEnabled()) {
            tv.disable();
            System.out.println("Power turned off");
        } else {
            tv.enable();
            System.out.println("Powerturned on");
        }
    }

    public void volumeUp() {
        if (tv.isEnabled()) {
            tv.setVolume(tv.getVolume() + 10);
            System.out.println("Volume increasedby 10");
        } else {
            System.out.println("Please turn on the TV first");
        }
    }

    public void volumeDown() {
        if (tv.isEnabled()) {
            tv.setVolume(tv.getVolume() - 10);
            System.out.println("Volume decreased by 10");
        } else {
            System.out.println("Please turn on the TV first");
        }
    }

    public void channelUp() {
        if (tv.isEnabled()) {
            tv.setChannel(tv.getChannel() + 5);
            System.out.println("Channel increasedby 5");
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

    SmartRemote(TV tv) {
        super(tv);
    }

    void showYoutube() {
        ((SmartTV) tv).Youtube();
    }
}

public class Main {
    public static void main(String[] args) {

        GeneralTV generaltv = new GeneralTV();
SmartTV smarttv = new SmartTV();

        Remote remote = new Remote(generaltv);
        remote.togglePower();
        remote.volumeUp();
        remote.channelUp();
         remote.channelDown();
        remote.volumeDown();

         SmartRemote smartremote = new SmartRemote(smarttv);
        smartremote.togglePower();
        smartremote.volumeUp();
        smartremote.channelUp();
        smartremote.channelDown();
        smartremote.volumeDown();
        smartremote.showYoutube();
       
    }
}
