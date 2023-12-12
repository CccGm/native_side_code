package com.native_code.send_data;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityDiscovery extends ActivityNet {


    private final String TAG = "ActivityDiscovery";
    public final static long VIBRATE = (long) 250;
    public final static int SCAN_PORT_RESULT = 1;
    public static final int MENU_SCAN_SINGLE = 0;
    public static final int MENU_OPTIONS = 1;
    public static final int MENU_HELP = 2;
    private static final int MENU_EXPORT = 3;
    private static LayoutInflater mInflater;
    private int currentNetwork = 0;
    private List<HostBean> hosts = null;
    private long network_ip = 0;
    private long network_start = 0;
    private long network_end = 0;
    private AbstractDiscovery mDiscoveryTask = null;
    @Override
    protected void setInfo() {

    }

    @Override
    protected void setButtons(boolean disable) {

    }

    @Override
    protected void cancelTasks() {

    }
    public void makeToast(int msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private void startDiscovering() {

        int method = 0;
//        try {
//            method = Integer.parseInt(prefs.getString(Prefs.KEY_METHOD_DISCOVER,
//                    Prefs.DEFAULT_METHOD_DISCOVER));
//        } catch (NumberFormatException e) {
//            Log.e("error 28 Activity", e.getMessage());
//        }
//        switch (method) {
//            case 1:
//                mDiscoveryTask = new DnsDiscovery(ActivityDiscovery.this);
//                break;
//            case 2:
//                // Root
//                break;
//            case 0:
//            default:
                mDiscoveryTask = new DefaultDiscovery(ActivityDiscovery.this);
//        }
        mDiscoveryTask.setNetwork(network_ip, network_start, network_end);
        mDiscoveryTask.execute();
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(true);

    }

    public void stopDiscovering() {
        Log.e("error 57 Activity", "stopDiscovering()");
        mDiscoveryTask = null;

        setProgressBarVisibility(false);
        setProgressBarIndeterminateVisibility(false);

    }

    public void addHost(HostBean host) {
        host.position = hosts.size();
        hosts.add(host);
    }



}
