package fi.oulu.unitour.helpers;

import android.graphics.Color;
import android.support.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import fi.oulu.unitour.R;

import static com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource;

/**
 * Created by Majid on 2/15/2017.
 */

public class QuestPointMaker {
    private static final int LOCATION_NUMBERS = 16;

    private static final LatLng KASTARI = new LatLng(65.057089, 25.467710);
    private static final LatLng TIETOTALO = new LatLng(65.057864, 25.469620);
    private static final LatLng DATAGARAGE = new LatLng(65.057985, 25.468475);
    private static final LatLng VENDORMACHINE = new LatLng(65.057882, 25.466895);
    private static final LatLng AIESEC = new LatLng(65.058162, 25.465801);
    private static final LatLng ITSERVICES = new LatLng(65.058488, 25.466938);
    private static final LatLng TELLUS = new LatLng(65.058602, 25.465740);
    private static final LatLng FABLAB = new LatLng(65.058996, 25.468047);
    private static final LatLng WALLINFRONTOFL2 = new LatLng(65.059103, 25.465779);
    private static final LatLng CENTRALSTATION = new LatLng(65.059218, 25.466481);
    private static final LatLng STUDENTCENTER = new LatLng(65.059888, 25.465022);
    private static final LatLng AVA = new LatLng(65.060229, 25.466622);
    private static final LatLng ZOOLOGICALMUSEUM = new LatLng(65.060612, 25.467339);
    private static final LatLng PEGASUSLIBRARY = new LatLng(65.061400, 25.466598);
    private static final LatLng BALANCE = new LatLng(65.061110, 25.468036);
    private static final LatLng FACULTYOFEDUCATION = new LatLng(65.061215, 25.468864);

    //private static final Polyline gameRoute;


    private static final LatLng[] checkpoints = {KASTARI,TIETOTALO,DATAGARAGE,VENDORMACHINE,AIESEC,ITSERVICES,TELLUS,FABLAB,WALLINFRONTOFL2,
            CENTRALSTATION,STUDENTCENTER,AVA,ZOOLOGICALMUSEUM,PEGASUSLIBRARY,BALANCE,FACULTYOFEDUCATION};
    private static final Marker[] uniMarkers = new Marker[LOCATION_NUMBERS];


    private static final BitmapDescriptor unfinishedCheckpoint = BitmapDescriptorFactory.fromResource(R.drawable.red_star);
    private static final BitmapDescriptor finishedCheckpoint = BitmapDescriptorFactory.fromResource(R.drawable.green_action);

    public QuestPointMaker() {


    }
    private Marker addMarker(GoogleMap map, LatLng coordination, String title, String snippet, BitmapDescriptor icon)
    {
        return map.addMarker(new MarkerOptions()
                .position(coordination)
                .title(title)
                .snippet(snippet)
                .icon(icon));
    }
    public Marker[] addCheckpoints(GoogleMap map)
    {
        for (int i = 0; i < LOCATION_NUMBERS; i++)
        {
            LatLng ltlg = checkpoints[i];
            String id = Integer.toString(i+1);
            uniMarkers[i] = addMarker(map,ltlg,ltlg.toString(),id, unfinishedCheckpoint);
        }
        return uniMarkers;
    }

    public void makeRoute(GoogleMap map)
    {
        int i = 0;
        while (i<=LOCATION_NUMBERS-2)
        {
            LatLng src = checkpoints[i];
            LatLng dest = checkpoints[i+1];
            map.addPolyline(new PolylineOptions().add(src,dest).width(10).color(Color.BLACK).geodesic(true));
            i=i+1;
        }
    }
}
