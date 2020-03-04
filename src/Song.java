// Aziz Yokubjonov - aziz.yokubjonov@gmail.com
// GitHub: @aziz512
// azizwrites.xyz

class Song {
    public String track;
    public String artist;
    private Song next;

    public Song(String songName, String artist) {
        this.track = songName;
        this.artist = artist;
    }

    public Song getNext() {
        if (next == null)
            return next;
        return next;
    }

    public void setNext(Song next) {
        this.next = next;
    }

    public Song copy() {
        return new Song(this.track, this.artist);
    }

    public int compareTo(Song another) {
        if (another == null)
            return 1;
        return this.track.compareToIgnoreCase(another.track);
    }
}