/**
 * This section of code is what I wrote:
 * It needs to have its seekBar controls finished for the vehicle to move, but there is no way to test that with the COVID-19 restrictions
 * The MainActivity controls the right and left drives of the vehicle, and has a "PAIR" button to take the user back to the Bluetooth LeGatt BLE Scanner
 */

package com.example.android.bluetoothlegatt;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter mBlueAdapter;
    SeekBar leftDrive;
    SeekBar rightDrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pairBtn = (Button) findViewById(R.id.bluetoothPair);
        TextView pairStat = (TextView) findViewById(R.id.pairStatus);

        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();

        //check if bluetooth is available

        if(mBlueAdapter == null)
        {
            pairStat.setText("Bluetooth Not Available");
        }
    }
    //This button takes you back to the Bluetooth LeGatt BLE Scanner activity
    public void pairBluetooth(View view)
    {
        Intent intent = new Intent(this, DeviceScanActivity.class);
        startActivity(intent);
    }

    /**
     * This section would contain the seekbar controls
     * Since there is no way for me to test it, I will not implement it
     * The seekBars will each have an onTouchListener, so that releasing your thumb is an event that sets the seekBar to the middle position, which is the stand still command for that drive
     * Each seekBar will have three positions ahead of and behind the middle position (slow, medium, and fast for either the forward or backward direction for that drive (left or right)
     * This chart is all different commands and associated characters:
     * Forward Left (Fast): a
     * Forward Left (Medium): b
     * Forward Left (Slow): c
     * Stand Still Left: s
     * Backward Left (Slow): d
     * Backward Left (Medium): e
     * Backward Let (Fast): f
     * Forward Right (Fast): A
     * Forward Right (Medium): B
     * Forward Right (Slow): C
     * Stand Still Right: S
     * Backward Right (Slow): D
     * Backward Right (Medium ): E
     * Backward Right (Fast): F
     */
}
