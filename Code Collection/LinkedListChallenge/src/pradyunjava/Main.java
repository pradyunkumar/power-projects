package pradyunjava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    //album making
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("How many albums do you want to make?");
        byte num = scanner.nextByte();
        scanner.nextLine();
        LinkedList<Song> playlist = new LinkedList<Song>();
        for(int i = 0; i<num; i++){
            Album myAlbum = makeAlbum();
            LinkedList<Song> AlbumPlaylist = pickSongs(myAlbum);
            playlist.addAll(AlbumPlaylist);
        }
        play(playlist);
    }

    //picking songs to add to the playlist
    private static LinkedList<Song> pickSongs(Album album){
        LinkedList<Song> list= new LinkedList<Song>();
        while(true) {
            System.out.println("Enter song to put in playlist from this album: " + "\n" +
                    "press 0 to continue");
            String name = scanner.nextLine();
            if(name.equals("0")) {
                break;
            }
            if(album.isThere(name) == null){
                System.out.println(name + " does not exist in " + album.getName());
            } else {
                list.add(album.isThere(name));
                System.out.println(name + " has been added to your playlist");
            }
        }
        return list;
    }

    private static Album makeAlbum(){
        System.out.println("Please enter album name: ");
        String name = scanner.nextLine();
        Album newAlbum = Album.addAlbum(name, new ArrayList<Song>());
        addSongs(newAlbum);
        return newAlbum;
    }

    //adds songs to the list
    private static void addSongs(Album a){
        System.out.println("Enter the songs for album " + a.getName());
        while(true){
            System.out.println("Enter a song to add to Album: ");
            System.out.println("To continue: press 0");
            String name = scanner.nextLine();
            scanner.nextLine();
            if(name.equals("0")){
                break;
            } else {
                System.out.print("Enter song duration: ");
                String duration = scanner.nextLine();
                scanner.nextLine();
                a.addSong(name, duration);
            }
        }
    }
    //menu for options
    private static void printMenu(){
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n " +
                "1 - skip to next song\n " +
                "2 - go back to previous song\n " +
                "3 - Replay current song\n " +
                "4 - Remove current song\n " +
                "5 - reprint menu\n");
    }
    //plays through the songs
    private static void play(LinkedList<Song> linkedList){
        ListIterator<Song> songListIterator = linkedList.listIterator();
        byte action = 0;
        boolean quit = false;
        boolean goingforward = true;
        if(linkedList.isEmpty()){
            System.out.println("No songs in playlist.");
        } else {
            System.out.println("Now playing " + songListIterator.next().getTitle());
            printMenu();
            while (!quit) {
                System.out.println("Please print a choice: ");
                action = scanner.nextByte();
                switch (action) {
                    case 0:
                        System.out.println("Playlist closed. ");
                        quit = true;
                        break;
                    case 1:
                        if(!goingforward){
                            if(songListIterator.hasNext()){
                                songListIterator.next();
                            }
                            goingforward = true;
                        }   //going forward
                        if(songListIterator.hasNext()){
                            System.out.println("Now playing " + songListIterator.next().getTitle());
                        } else {
                            System.out.println("Reached end of playlist.");
                            goingforward = false;
                        }
                        break;
                    case 2:
                        if(goingforward){
                            if(songListIterator.hasPrevious()){
                                songListIterator.previous();
                            }
                            goingforward = false;
                        }   //going backward
                        if(songListIterator.hasPrevious()){
                            System.out.println("Now playing " + songListIterator.previous().getTitle());
                        } else {
                            System.out.println("Reached beginning of playlist.");
                            goingforward = true;
                        }
                        break;
                    case 3:
                        if(!goingforward){
                            if (songListIterator.hasNext()) {
                                songListIterator.next();
                                goingforward = true;
                            }
                        }
                        System.out.println("Replaying " + songListIterator.previous().getTitle());
                        break;
                    case 4:
                        System.out.println("Removing " + songListIterator.previous().getTitle());
                        songListIterator.remove();
                        break;
                    case 5:
                        printMenu();
                        break;
                }
            }
        }
        scanner.close();
    }
}
