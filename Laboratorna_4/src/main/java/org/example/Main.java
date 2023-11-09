package org.example;

import CommandForDisk.*;
import CommandForMusicAlbum.*;
import Disk.Disk;
import MusicAlbum.MusicAlbum;
import MusicComposition.MusicComposition;


import java.util.*;

import Menu.Menu;


public class Main {

    public static void printLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("=");
        }
        System.out.println("");
    }

    public static MusicComposition enterComposition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву композиції - ");
        String name = scanner.nextLine();
        System.out.println("Введіть ім'я артиста - ");
        String artist = scanner.nextLine();
        System.out.println("Введіть стиль композиції - ");
        String style = scanner.nextLine();
        System.out.println("Введіть тривалість композиції(від 1) - ");

        double duration = scanner.nextDouble();
        while (duration <= 0) {
            System.out.println("Ви ввели " + duration + " ,а потрібно мінімум 1 хв");
            System.out.println("Введіть тривалість композиції(від 1) - ");
            duration = scanner.nextDouble();
        }
        MusicComposition composition = new MusicComposition(name, artist, style, duration);
        return composition;
    }

    public static MusicAlbum chooseAlbum(Disk disk) {
        if (disk.getAlbumsOnDisk().isEmpty()) {
            System.out.println("На диску немає записаних альбомів.");
            return null;
        }
        disk.printRecordedAlbums();
        Scanner scanner = new Scanner(System.in);
        int albumChoice;
        do {
            System.out.print("Виберіть альбом (введіть номер): ");
            albumChoice = scanner.nextInt();
            scanner.nextLine();
        } while (albumChoice < 1 || albumChoice > disk.getAlbumsOnDisk().size());

        MusicAlbum selectedAlbum = disk.getAlbumsOnDisk().get(albumChoice - 1);
        return selectedAlbum;

    }

    public static void createMenu(Disk disk) {

        Menu menu = new Menu();

        menu.addCommand(new CreateAlbumCommand(disk));
        menu.addCommand(new ReadMusicAlbumsFromFileCommand(disk));
        menu.addCommand(new ShowAlbumsOnDiskCommand(disk));
        menu.addCommand(new AddCompositionInAlbumCommand(disk));
        menu.addCommand(new RemoveCompositionFromAlbumCommand(disk));

        menu.addCommand(new DeleteCollectionFromDiskCommand(disk));
        menu.addCommand(new FindCompositionByLengthCommand(disk));
        menu.addCommand(new RearrangeCompositionsByStyleCommand(disk));
        menu.addCommand(new RearrangeCompositionsByDurationCommand(disk));
        menu.addCommand(new CalculateDurationInAlbumCommand(disk));
        menu.addCommand(new CalculateDurationOnDiskCommand(disk));
        menu.run();

    }

    public static void main(String[] args) {

        Disk disk = new Disk("Disk");
        createMenu(disk);

    }
}