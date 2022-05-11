package door;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]) {
        Door d = new Door();
        List<Door> l = new ArrayList<>();
        l.add(new Door());
        l.add(new DoorHS());
        l.add(new DoorAutoLock());
        l.add(new DoorSecretCode(1));
        l.add(new DoorAutoLock());
        l.add(new DoorSecretCode(2));
        l.add(new Door());

        /* Opens each door*/
        l = l.stream()
                .map(x -> {
                    x.open();
                    return x;
                })
                .collect(Collectors.toList());

        /* counts the doors which are opened */
        long nbOpenAutoLock
                = l.stream()
                .filter(x -> x.isOpen())
                .count();

        /* filter DoorSecretCode and close each */
        List<Door> secretCodeCloseList
                = l.stream()
                .filter(x -> x instanceof DoorSecretCode)
                .map(x -> {
                    x.close();
                    return x;
                })
                .collect(Collectors.toList());

    }

}
