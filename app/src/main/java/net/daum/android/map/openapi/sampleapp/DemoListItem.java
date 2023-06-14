package net.daum.android.map.openapi.sampleapp;

import android.support.v4.app.FragmentActivity;

import net.daum.android.map.openapi.sampleapp.demos.CameraDemoActivity;
import net.daum.android.map.openapi.sampleapp.demos.EventsDemoActivity;
import net.daum.android.map.openapi.sampleapp.demos.LocationDemoActivity;
import net.daum.android.map.openapi.sampleapp.demos.MapViewDemoActivity;
import net.daum.android.map.openapi.sampleapp.demos.MarkerDemoActivity;
import net.daum.android.map.openapi.sampleapp.demos.PolygonDemoActivity;


public class DemoListItem {
	public final int titleId;
	public final int descriptionId;
	public final Class<? extends FragmentActivity> activity;

	public DemoListItem(int titleId, int descriptionId,
			Class<? extends FragmentActivity> activity) {
		this.titleId = titleId;
		this.descriptionId = descriptionId;
		this.activity = activity;
	}

	public static final DemoListItem[] DEMO_LIST_ITEMS = {
			//리스트 항목 1
			new DemoListItem(R.string.map_view_demo_title,
					R.string.map_view_demo_desc, MapViewDemoActivity.class),

			//리스트 항복 2
			new DemoListItem(R.string.camera_demo_title,
					R.string.camera_demo_desc, CameraDemoActivity.class),
	};
}
