package pw7;
//порядок работы системы

public class Facade {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();
    public void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on(){
        System.out.println("Включение питания");
    }
    void off(){
        System.out.println("Выключение питания");
    }
}

class DVDRom{
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void load(){
        data = true;
    }
    void unload(){
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("Данные с диска скопированы");
        }
        else {
            System.out.println("Вставьте диск");
        }
    }
}
