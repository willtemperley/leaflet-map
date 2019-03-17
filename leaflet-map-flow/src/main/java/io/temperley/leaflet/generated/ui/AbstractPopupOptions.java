package io.temperley.leaflet.generated.ui;

import io.temperley.leaflet.basetypes.LeafletPoint;
import java.lang.Boolean;
import java.lang.Number;
import java.lang.String;

public abstract class AbstractPopupOptions<T extends AbstractPopupOptions<T>> extends AbstractDivoverlayOptions<T> {
    /**
     * Max width of the popup, in pixels.
     * default: 300
     */
    public T maxWidth(Number maxWidth) {
        addOption("maxWidth", maxWidth);
        return this.get();
    }

    /**
     * Min width of the popup, in pixels.
     * default: 50
     */
    public T minWidth(Number minWidth) {
        addOption("minWidth", minWidth);
        return this.get();
    }

    /**
     * If set, creates a scrollable container of the given height inside a popup if its content exceeds it.
     * default: null
     */
    public T maxHeight(Number maxHeight) {
        addOption("maxHeight", maxHeight);
        return this.get();
    }

    /**
     * Set it to false if you don't want the map to do panning animation to fit the opened popup.
     * default: true
     */
    public T autoPan(Boolean autoPan) {
        addOption("autoPan", autoPan);
        return this.get();
    }

    /**
     * The margin between the popup and the top left corner of the map view after autopanning was performed.
     * default: null
     */
    public T autoPanPaddingTopLeft(LeafletPoint autoPanPaddingTopLeft) {
        addOption("autoPanPaddingTopLeft", autoPanPaddingTopLeft);
        return this.get();
    }

    /**
     * The margin between the popup and the bottom right corner of the map view after autopanning was performed.
     * default: null
     */
    public T autoPanPaddingBottomRight(LeafletPoint autoPanPaddingBottomRight) {
        addOption("autoPanPaddingBottomRight", autoPanPaddingBottomRight);
        return this.get();
    }

    /**
     * Equivalent of setting both top left and bottom right autopan padding to the same value.
     * default: Point(5, 5)
     */
    public T autoPanPadding(LeafletPoint autoPanPadding) {
        addOption("autoPanPadding", autoPanPadding);
        return this.get();
    }

    /**
     * Set it to true if you want to prevent users from panning the popup off of the screen while it is open.
     * default: false
     */
    public T keepInView(Boolean keepInView) {
        addOption("keepInView", keepInView);
        return this.get();
    }

    /**
     * Controls the presence of a close button in the popup.
     * default: true
     */
    public T closeButton(Boolean closeButton) {
        addOption("closeButton", closeButton);
        return this.get();
    }

    /**
     * Set it to false if you want to override the default behavior of the popup closing when another popup is opened.
     * default: true
     */
    public T autoClose(Boolean autoClose) {
        addOption("autoClose", autoClose);
        return this.get();
    }

    /**
     * Set it to false if you want to override the default behavior of the ESC key for closing of the popup.
     * default: true
     */
    public T closeOnEscapeKey(Boolean closeOnEscapeKey) {
        addOption("closeOnEscapeKey", closeOnEscapeKey);
        return this.get();
    }

    /**
     * Set it if you want to override the default behavior of the popup closing when user clicks on the map. Defaults to the map's closePopupOnClick option.
     * default: *
     */
    public T closeOnClick(Boolean closeOnClick) {
        addOption("closeOnClick", closeOnClick);
        return this.get();
    }

    /**
     * A custom CSS class name to assign to the popup.
     * default: ''
     */
    public T className(String className) {
        addOption("className", className);
        return this.get();
    }
}
