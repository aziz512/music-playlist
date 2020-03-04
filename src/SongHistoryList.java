// Aziz Yokubjonov - aziz.yokubjonov@gmail.com
// GitHub: @aziz512
// azizwrites.xyz

class SongHistoryList {
    private Song head;

    public void addSong(Song s) {
        Song songCopy = s.copy();
        if (head == null) {
            head = songCopy;
            return;
        }
        songCopy.setNext(head);
        this.head = songCopy;
    }

    public Song lastListened() {
        return head;
    }
}