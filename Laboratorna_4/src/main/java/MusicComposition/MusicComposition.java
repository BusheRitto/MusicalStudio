package MusicComposition;


public class MusicComposition {
    private String name;
    private String artist;
    private String style;

    private double duration;

    public MusicComposition(String name, String artist, String style, double duration) {
        this.name = name;
        this.artist = artist;
        this.style = style;
        this.duration = duration;
    }


    public String getName() {
        return name;
    }


    public String getStyle() {
        return style;
    }

    public double getDuration() {
        return duration;
    }


    @Override
    public String toString() {
        return "\nМузична композиція \n{" +
                "Назва - " + name + '\n' +
                "Артист - " + artist + '\n' +
                "Cтиль композиції - " + style + '\n' +
                "Тривалість - " + duration + "\n" +
                "==========================";
    }


}
