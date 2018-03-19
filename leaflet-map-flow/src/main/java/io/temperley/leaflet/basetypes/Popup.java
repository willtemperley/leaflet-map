package io.temperley.leaflet.basetypes;


//dummy object, will probably be a Component at some point
public class Popup {

    private final String todo;

    public Popup(String todo) {
        this.todo = todo;
    }

    public static Popup fromString(String str) {
        return new Popup("TODO");
    }
}
