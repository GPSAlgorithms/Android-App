package net.daum.android.map.openapi.sampleapp.demos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import net.daum.android.map.openapi.sampleapp.MapApiConst;
import net.daum.android.map.openapi.sampleapp.R;
import net.daum.mf.map.api.CameraPosition;
import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.CancelableCallback;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapView;

public class CameraDemoActivity extends FragmentActivity implements MapView.MapViewEventListener {

    private static final int MENU_CAMERA_1 = Menu.FIRST;
    private static final int MENU_CAMERA_2 = Menu.FIRST + 1;
    private static final int MENU_CAMERA_3 = Menu.FIRST + 2;

    private MapView mapView;

    private static final MapPoint MAP_POINT_POI1 = MapPoint.mapPointWithGeoCoord(36.36452167, 127.32534767);
    private static final MapPoint MAP_POINT_POI2 = MapPoint.mapPointWithGeoCoord(36.33267310, 127.43600320);
    
    private static final CameraPosition CAMERA_POSITION_stadium = new CameraPosition(MapPoint.mapPointWithGeoCoord(36.36452167, 127.32534767), 2);
    private static final CameraPosition CAMERA_POSITION_station = new CameraPosition(MapPoint.mapPointWithGeoCoord(36.33267310, 127.43600320), 2);
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_camera);
        mapView = (MapView)findViewById(R.id.map_view);
        mapView.setDaumMapApiKey(MapApiConst.DAUM_MAPS_ANDROID_APP_API_KEY);
        mapView.setMapViewEventListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_CAMERA_1, Menu.NONE, "GPS 1");
        menu.add(0, MENU_CAMERA_2, Menu.NONE, "GPS 2");
        menu.add(0, MENU_CAMERA_3, Menu.NONE, "전체 기기");

        return true;
    }
    
    public void onGoToStadium(View view) {
    	mapView.animateCamera(CameraUpdateFactory.newCameraPosition(CAMERA_POSITION_stadium), 1000, new CancelableCallback() {
			@Override
			public void onFinish() {
                Toast.makeText(getBaseContext(), "현재 위치 : 대전광역시 유성구 월드컵대로 32", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onCancel() {
                Toast.makeText(getBaseContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
			}
		});
    }
    
    public void onGoToStation(View view) {
    	mapView.animateCamera(CameraUpdateFactory.newCameraPosition(CAMERA_POSITION_station), 1000, new CancelableCallback() {
			@Override
			public void onFinish() {
				Toast.makeText(getBaseContext(), "현재 위치 : 대전 동구 소제동 293-9", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onCancel() {
				Toast.makeText(getBaseContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_CAMERA_1 : {
                toast(item.getTitle());
                mapView.moveCamera(CameraUpdateFactory.newMapPoint(MAP_POINT_POI1));
                return true;
            }
            case MENU_CAMERA_2 : {
                toast(item.getTitle());
                mapView.moveCamera(CameraUpdateFactory.newMapPoint(MAP_POINT_POI2));
                return true;
            }
            case MENU_CAMERA_3 : {
                toast(item.getTitle());
                MapPointBounds bounds = new MapPointBounds(MAP_POINT_POI1, MAP_POINT_POI2);
                mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(bounds, 100, 3, 7));
                return true;
            }
        }

        return onOptionsItemSelected(item);
    }

    private void toast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {
        // MapView had loaded. Now, MapView APIs could be called safely.

        MapPOIItem poiItem1 = new MapPOIItem();
        poiItem1.setItemName("사용자 정보(GPS1)");
        poiItem1.setMapPoint(MAP_POINT_POI1);
        poiItem1.setMarkerType(MapPOIItem.MarkerType.BluePin);
        mapView.addPOIItem(poiItem1);

        MapPOIItem poiItem2 = new MapPOIItem();
        poiItem2.setItemName("사용자 정보(GPS2)");
        poiItem2.setMapPoint(MAP_POINT_POI2);
        poiItem2.setMarkerType(MapPOIItem.MarkerType.YellowPin);
        mapView.addPOIItem(poiItem2);
    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapCenterPoint) {
    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int zoomLevel) {
    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {
    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }
}
