# Top Streaming Artists

The program analyzes all the files in the `/data` directory and parses song titles and their corresponding artists. Then it puts all the titles together in a sorted (ascending) playlist. The CSV files must be from [Spotify Charts](https://spotifycharts.com/) or have the same structure.
The playlist is a state manager that stores the currently played song and the history of all plays.
## Dependencies

* [Java 8](https://docs.oracle.com/javase/8/docs/api/index.html)

## Setup
1) `git clone https://github.com/aziz512/music-playlist.git`
2) `cd music-playlist/src`
3) `javac Main.java && java Main` 
4) Follow instructions in the program: (enter 'n' for next song and 'h' for playback history)

## Folder Structure

* Code is saved into the `src` folder.
* Data is parsed from the csv files in the `data` folder.
* Output is printed in the console