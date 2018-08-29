package com.google.photos.library.v1.util;

import com.google.photos.library.v1.proto.Location;
import com.google.photos.library.v1.proto.LocationEnrichment;
import com.google.photos.library.v1.proto.MapEnrichment;
import com.google.photos.library.v1.proto.NewEnrichmentItem;
import com.google.photos.library.v1.proto.TextEnrichment;
import com.google.type.LatLng;

/** Factory class to create different {@link NewEnrichmentItem}s. */
public final class NewEnrichmentItemFactory {
  private NewEnrichmentItemFactory() {}

  /** Creates a {@link NewEnrichmentItem} with a {@link TextEnrichment}. */
  public static final NewEnrichmentItem createTextEnrichment(String text) {
    return NewEnrichmentItem.newBuilder()
        .setTextEnrichment(TextEnrichment.newBuilder().setText(text).build())
        .build();
  }

  /**
   * Creates a {@link NewEnrichmentItem} with a {@link LocationEnrichment}.
   *
   * @throws IllegalArgumentException Thrown if the location name is null or empty.
   */
  public static final NewEnrichmentItem createLocationEnrichment(
      String locationName, double latitude, double longitude) {
    if (locationName == null || locationName.isEmpty()) {
      throw new IllegalArgumentException("Location name cannot be null or empty.");
    }

    return NewEnrichmentItem.newBuilder()
        .setLocationEnrichment(
            LocationEnrichment.newBuilder()
                .setLocation(
                    Location.newBuilder()
                        .setLocationName(locationName)
                        .setLatlng(
                            LatLng.newBuilder().setLatitude(latitude).setLongitude(longitude))))
        .build();
  }

  /**
   * Creates a {@link NewEnrichmentItem} with a {@link MapEnrichment}.
   *
   * @throws IllegalArgumentException Thrown if the origin or destination location names are either
   *     null or empty.
   */
  public static final NewEnrichmentItem createMapEnrichment(
      String originLocationName,
      double originLatitude,
      double originLongitude,
      String destinationLocationName,
      double destinationLatitude,
      double destinationLongitude) {
    if (originLocationName == null || originLocationName.isEmpty()) {
      throw new IllegalArgumentException("Origin location name cannot be null or empty.");
    }
    if (destinationLocationName == null || destinationLocationName.isEmpty()) {
      throw new IllegalArgumentException("Destination location name cannot be null or empty.");
    }

    Location.Builder originLocation =
        Location.newBuilder()
            .setLocationName(originLocationName)
            .setLatlng(
                LatLng.newBuilder().setLatitude(originLatitude).setLongitude(originLongitude));

    Location.Builder destinationLocation =
        Location.newBuilder()
            .setLocationName(destinationLocationName)
            .setLatlng(
                LatLng.newBuilder()
                    .setLatitude(destinationLatitude)
                    .setLongitude(destinationLongitude));

    return NewEnrichmentItem.newBuilder()
        .setMapEnrichment(
            MapEnrichment.newBuilder()
                .setOrigin(originLocation)
                .setDestination(destinationLocation))
        .build();
  }
}
