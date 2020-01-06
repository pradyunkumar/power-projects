package pradyunjava;

import java.util.ArrayList;

//album is a list of songs
public class Album {
    private String name;
    private ArrayList<Song> album;

    public Album(String name, ArrayList<Song> album){
        this.name = name;
        this.album = new ArrayList<Song>();
    }

    public void addSong(String name, String duration){
        if(isThere(name)!=null){
            System.out.println(name + " already exists.");
        } else {
            Song newSong = Song.addSong(name, duration);
            album.add(newSong);
            System.out.println(name + " has been added to " + this.name);
        }
    }

    public Song isThere(String name) {
        for (int i = 0; i < album.size(); i++) {
            Song aSong = album.get(i);
            if (name.equals(aSong.getTitle())) {
                return aSong;
            }
        }
        return null;
        //for(Song checkedSong: this.songs){
        //  if(checkedSong.getTitle().equals(title))
        //      return checkSong;
        //    }
        // }
        //return null;
    }

    public String getName() {
        return name;
    }

    public static Album addAlbum(String name, ArrayList<Song> songArrayList){
        return new Album(name, songArrayList);
    }
}
