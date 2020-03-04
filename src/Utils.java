// Aziz Yokubjonov - aziz.yokubjonov@gmail.com
// GitHub: @aziz512
// azizwrites.xyz

import java.util.ArrayList;

class Utils {
    // parses a line in a CSV file and returns an array of its columns
    public static ArrayList<String> parseCSVLine(String line) {
        ArrayList<String> result = new ArrayList<>();
        boolean isQuoted = false;
        ArrayList<Integer> delimeterLocations = new ArrayList<>();

        // walk the string char-by-char and find true delimeters
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar == '"') { // handle quote escaping
                if (line.length() > i + 1) {
                    char nextChar = line.charAt(i + 1);
                    if (nextChar == '"') {
                        i++; // skip the escaped quote
                        continue;
                    }
                }
                isQuoted = !isQuoted; // no escaping, value wrapped in quotes
            } else if (!isQuoted && currentChar == ',') {
                delimeterLocations.add(i);
            }
        }

        if (delimeterLocations.size() == 0) { // only one column in line
            result.add(line);
            return result;
        }
        for (int i = 0; i < delimeterLocations.size(); i++) {
            int previous = 0;
            if (i != 0) {
                previous = delimeterLocations.get(i - 1) + 1;
            }
            result.add(line.substring(previous, delimeterLocations.get(i)));
        }
        // add column after last delimeter (aka last column)
        int lastDelimeter = delimeterLocations.get(delimeterLocations.size() - 1);
        result.add(line.substring(lastDelimeter + 1));
        return result;
    }

    // traverses the first 10 items of the given playlist and prints each song on a
    // separate line
    public static void printTenItemsOfPlaylist(Playlist playlist) {
        System.out.println();
        System.out.println("Songs in the playlist: \n");
        Song current = playlist.first;
        for (int i = 0; i < 10; i++) {
            if (current != null) {
                System.out.println(current.track);
                current = current.getNext();
            } else {
                // there are less than 10 items in the playlist
                break;
            }
        }
        System.out.println("...\n");
    }

    // prints listening history given a history list
    public static void printHistory(SongHistoryList list) {
        System.out.println("\nListening history (last listened appears first): \n");
        Song current = list.lastListened();
        while (current != null) {
            System.out.printf("%s - %s\n", current.track, current.artist);
            current = current.getNext();
        }
        System.out.println();
    }
}