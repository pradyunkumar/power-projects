package pradyunjava;

//song object
public class Song {
    private String title;
    private String duration;

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public static Song addSong(String name, String duration){
        return new Song(name, duration);
    }
}
