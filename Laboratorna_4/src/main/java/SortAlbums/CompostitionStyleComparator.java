package SortAlbums;

import MusicAlbum.MusicAlbum;
import MusicComposition.MusicComposition;

import java.util.Comparator;

public class CompostitionStyleComparator implements Comparator<MusicComposition> {
    @Override
    public int compare(MusicComposition compos1, MusicComposition compos2) {
        return compos1.getStyle().compareTo(compos2.getStyle());
    }
}
