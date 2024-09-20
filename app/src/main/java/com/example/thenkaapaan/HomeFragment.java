package com.example.thenkaapaan;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.airbnb.lottie.LottieAnimationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private LocationManager locationManager;
    private ConstraintLayout constraintLayout;
    private ConstraintLayout constraintLayout3;
    private TextView temperatureTextView;
    private TextView weatherConditionTextView;
    private TextView humidityTextView;
    private TextView windSpeedTextView;
    private LottieAnimationView lottieMenu;
    Boolean isMenuClicked;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        init(view);

        constraintLayout = view.findViewById(R.id.constraintLayout);
        constraintLayout3 = view.findViewById(R.id.constraintLayout3);
        temperatureTextView = view.findViewById(R.id.temperatureTextView);
        weatherConditionTextView = view.findViewById(R.id.weatherConditionTextView);
        humidityTextView = view.findViewById(R.id.humidityTextView);
        windSpeedTextView = view.findViewById(R.id.windSpeedTextView);


        locationManager = (LocationManager) requireActivity().getSystemService(Context.LOCATION_SERVICE);

        constraintLayout.setOnClickListener(view1 -> {
            if (checkLocationPermission())
            {
                getLocation();
            }else {
                requestLocationPermission();
            }
        });


        constraintLayout3.setOnClickListener(view2 ->{
            startActivity(new Intent(getActivity(), ScanActivity.class));
        });

        animation();

        return view;
    }

    private boolean checkLocationPermission() {
        return ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED;
    }

    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
    }

    private void getLocation() {
        if (locationManager.isProviderEnabled(LocationManager
                .GPS_PROVIDER)) {
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } else {
            showGPSDisabledAlert();
        }
    }

    private void showGPSDisabledAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setMessage("GPS is disabled. Do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Enable GPS",
                        (dialog, id) -> {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                (dialog, id) -> dialog.cancel());
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    private final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            try {
                String apiKey = "46f7c80e5cdda716d91dc3e24ea9daea";
                String apiUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude + "&lon=" + longitude + "&exclude=minutely,hourly,daily&appid=" + apiKey;
                String weatherData = WeatherAPI.getWeatherData(apiUrl);
                JSONObject jsonObject = new JSONObject(weatherData);
                JSONObject currentWeather = jsonObject.getJSONObject("current");

                double temp = currentWeather.getDouble("temp");
                int humidity = currentWeather.getInt("humidity");
                double windSpeed = currentWeather.getDouble("wind_speed");
                JSONArray weatherArray = currentWeather.getJSONArray("weather");
                JSONObject weatherObject = weatherArray.getJSONObject(0);
                String weatherDescription = weatherObject.getString("description");

                updateWeatherUI(temp, weatherDescription, humidity, windSpeed);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
    };

    public static class WeatherAPI {

        // Method to make HTTP GET request to the weather API endpoint
        public static String getWeatherData(String apiUrl) throws IOException {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Read the input stream into a String
                StringBuilder buffer = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                return buffer.toString();
            } finally {
                // Close the connections and readers
                if (connection != null) {
                    connection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private void updateWeatherUI(double temperature, String condition, int humidity, double windSpeed) {
        Log.d("WeatherData", "Temperature: " + temperature + "°C, Condition: " + condition + ", Humidity: " + humidity + "%, Wind Speed: " + windSpeed + " km/h");
        temperatureTextView.setText(temperature + "°C");
        weatherConditionTextView.setText(condition);
        humidityTextView.setText(humidity + "%");
        windSpeedTextView.setText(windSpeed + " km/h");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                Toast.makeText(requireContext(), "Location permission denied", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void init(View view) {
        isMenuClicked = false;
        lottieMenu = view.findViewById(R.id.lottie_menu);
    }
    private void animation() {

        // Menu Animation
        lottieMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isMenuClicked) {
                    lottieMenu.setSpeed(-1);
                    lottieMenu.playAnimation();
                    isMenuClicked = false;

                } else {
                    lottieMenu.setSpeed(1);
                    lottieMenu.playAnimation();
                    isMenuClicked = true;
                }
            }
        });
    }

}