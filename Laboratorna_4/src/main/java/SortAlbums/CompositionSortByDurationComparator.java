package SortAlbums;

import MusicComposition.MusicComposition;

import java.util.Comparator;

public class CompositionSortByDurationComparator implements Comparator<MusicComposition> {
    @Override
    public int compare(MusicComposition c1, MusicComposition c2) {
        return Double.compare(c1.getDuration(), c2.getDuration());
    }
}
