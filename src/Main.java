// Aziz Yokubjonov - aziz.yokubjonov@gmail.com
// GitHub: @aziz512
// azizwrites.xyz

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File dataFolder = new File("../data");
        File[] files = dataFolder.listFiles();
        // build a playlist based on the csv files in the data directory
        Playlist playlist = new Playlist(files);

        Scanner keyboard = new Scanner(System.in);
        Utils.printTenItemsOfPlaylist(playlist);
        do {
            System.out.println("=============");
            System.out.println("Actions:");
            System.out.println("n) next track \nh) song history \nq) quit");
            System.out.print("Your choice: ");

            char command;
            try {
                command = keyboard.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }
            if (command == 'n') {
                Song currentSong = playlist.listenToSong();
                System.out.println("\n");
                System.out.printf("Currently listening: %s by %s", currentSong.track, currentSong.artist);
                System.out.println("\n");
                Utils.printTenItemsOfPlaylist(playlist);
            } else if (command == 'h') {
                Utils.printHistory(playlist.history);
            } else if (command == 'q') {
                break;
            }
        } while (true);
    }
}