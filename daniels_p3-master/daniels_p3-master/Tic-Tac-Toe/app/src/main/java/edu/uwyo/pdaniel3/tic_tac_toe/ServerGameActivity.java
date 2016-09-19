package edu.uwyo.pdaniel3.tic_tac_toe;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.UUID;

public class ServerGameActivity extends AppCompatActivity {

    public static final UUID MY_UUID = UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
    public static final String NAME = "BluetoothDemo";

    private BluetoothAdapter mBluetoothAdapter = null;
    private BluetoothSocket socket = null;

    private final String PLAYERX = "player X";
    private final String PLAYER0 = "player O";
    private final String PLAYAGAIN = "playagain";
    private final String DISAGREE = "disagree";
    private final String AGREE = "agree";
    private final String ONE = "1";
    private final String TWO = "2";
    private final String THREE = "3";
    private final String FOUR = "4";
    private final String FIVE = "5";
    private final String SIX = "6";
    private final String SEVEN = "7";
    private final String EIGHT = "8";
    private final String NINE = "9";

    private TextView mScoreText;
    private TextView mServerClient;
    private TextView output;

    private Button mButton;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button beX;
    private Button beO;
    private Button mPlayAgain;

    private boolean mButtonClicked = false;
    private boolean mButtonClicked2 = false;
    private boolean mButtonClicked3 = false;
    private boolean mButtonClicked4 = false;
    private boolean mButtonClicked5 = false;
    private boolean mButtonClicked6 = false;
    private boolean mButtonClicked7 = false;
    private boolean mButtonClicked8 = false;
    private boolean mButtonClicked9 = false;
    private boolean sides_chosen = false;

    private int x_wins = 0;
    private int o_wins = 0;
    private int ties = 0;

    private boolean tie = false;
    private boolean win = false;
    private boolean x_turn = true;

    private boolean waiting = false;

    private String currentMessage = null;

    private boolean imX = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        addButtons();
        addTextViews();

        //setup the bluetooth adapter.

    }

    public void addTextViews() {

        mScoreText = (TextView) findViewById(R.id.score);
        mScoreText.setText("X wins: " + x_wins + " O wins: " + o_wins);

        output = (TextView) findViewById(R.id.output);

        mServerClient = (TextView) findViewById(R.id.serclient);
        mServerClient.setText("You are the server");
    }

    public void addButtons() {
        mPlayAgain = (Button) findViewById(R.id.playagain);
        mPlayAgain.setEnabled(false);

        beO = (Button) findViewById(R.id.beO);
        beO.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = PLAYER0;
                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    // Device does not support Bluetooth
                    output.append("No bluetooth device.\n");
                }

                sides_chosen = true;

                output.append("Starting server\n");
                beX.setEnabled(false);
                beO.setEnabled(false);
                mButton.setEnabled(true);
                mButton2.setEnabled(true);
                mButton3.setEnabled(true);
                mButton4.setEnabled(true);
                mButton5.setEnabled(true);
                mButton6.setEnabled(true);
                mButton7.setEnabled(true);
                mButton8.setEnabled(true);
                mButton9.setEnabled(true);
                startServer();
            }
        });

        beX = (Button) findViewById(R.id.beX);
        beX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = PLAYERX;
                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    // Device does not support Bluetooth
                    output.append("No bluetooth device.\n");
                }

                output.append("Starting server\n");
                beX.setEnabled(false);
                beO.setEnabled(false);
                mButton.setEnabled(true);
                mButton2.setEnabled(true);
                mButton3.setEnabled(true);
                mButton4.setEnabled(true);
                mButton5.setEnabled(true);
                mButton6.setEnabled(true);
                mButton7.setEnabled(true);
                mButton8.setEnabled(true);
                mButton9.setEnabled(true);
                sides_chosen = true;


                startServer();

            }
        });

        mButton = (Button) findViewById(R.id.one);
        mButton.setEnabled(false);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "1";
            }
        });

        mButton2 = (Button) findViewById(R.id.two);
        mButton2.setEnabled(false);
        mButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "2";
            }
        });

        mButton3 = (Button) findViewById(R.id.three);
        mButton3.setEnabled(false);
        mButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "3";
            }
        });

        mButton4 = (Button) findViewById(R.id.four);
        mButton4.setEnabled(false);
        mButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "4";
            }
        });

        mButton5 = (Button) findViewById(R.id.five);
        mButton5.setEnabled(false);
        mButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "5";
            }
        });

        mButton6 = (Button) findViewById(R.id.six);
        mButton6.setEnabled(false);
        mButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "6";
            }
        });

        mButton7 = (Button) findViewById(R.id.seven);
        mButton7.setEnabled(false);
        mButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "7";
            }
        });

        mButton8 = (Button) findViewById(R.id.eight);
        mButton8.setEnabled(false);
        mButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "8";
            }
        });

        mButton9 = (Button) findViewById(R.id.nine);
        mButton9.setEnabled(false);
        mButton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentMessage = "9";
            }
        });

    }

    public String handleMessage(String message) {
        String returnM = "";
        if (message.compareTo(PLAYERX) == 0) {
            if (sides_chosen != true) {
                sides_chosen = true;
                returnM = AGREE;
            }
        } else if (message.compareTo(PLAYER0) == 0) {
            if (sides_chosen != true) {
                sides_chosen = true;
                returnM = AGREE;
            }
        } else if (message.compareTo(ONE) == 0) {
            int r = check_valid_spot(1);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(TWO) == 0) {
            int r = check_valid_spot(2);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(THREE) == 0) {
            int r = check_valid_spot(3);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(FOUR) == 0) {
            int r = check_valid_spot(4);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(FIVE) == 0) {
            int r = check_valid_spot(5);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(SIX) == 0) {
            int r = check_valid_spot(6);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(SEVEN) == 0) {
            int r = check_valid_spot(7);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(EIGHT) == 0) {
            int r = check_valid_spot(8);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(NINE) == 0) {
            int r = check_valid_spot(9);
            String temp = AGREE;
            if (r == -1) {
                temp = DISAGREE;
            }
            returnM = temp;
        } else if (message.compareTo(PLAYAGAIN) == 0) {

            String temp = "disagree";
            if (win) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                String temp = AGREE;
                                resetGame();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
            returnM = temp;
        } else if (message.compareTo(AGREE) == 0) {
            returnM = AGREE;
        } else {
            returnM = DISAGREE;
        }
        return returnM;
    }

    public int check_valid_spot(int spot) {


        String setText = "";
        if (x_turn) {
            setText = "X";
        } else {
            setText = "O";
        }

        int returnVal = -1;
        switch (spot) {
            case 1:
                if (!mButtonClicked) {
                    mButton.setText(setText);
                    mButton.setEnabled(false);
                    mButtonClicked = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
                break;
            case 2:
                if (!mButtonClicked2) {
                    mButton2.setText(setText);
                    mButton2.setEnabled(false);
                    mButtonClicked2 = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
                break;
            case 3:
                if (!mButtonClicked3) {
                    mButton3.setText(setText);
                    mButton3.setEnabled(false);
                    mButtonClicked3 = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
            case 4:
                if (!mButtonClicked4) {
                    mButton4.setText(setText);
                    mButton4.setEnabled(false);
                    mButtonClicked4 = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
                break;
            case 5:
                if (!mButtonClicked5) {
                    mButton5.setText(setText);
                    mButton5.setEnabled(false);
                    mButtonClicked5 = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
                break;
            case 6:
                if (!mButtonClicked6) {
                    mButton6.setText(setText);
                    mButton6.setEnabled(false);
                    mButtonClicked6 = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
                break;
            case 7:
                if (!mButtonClicked6) {
                    mButton6.setText(setText);
                    mButton6.setEnabled(false);
                    mButtonClicked6 = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
                break;
            case 8:
                if (!mButtonClicked6) {
                    mButton6.setText(setText);
                    mButton6.setEnabled(false);
                    mButtonClicked6 = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
                break;
            case 9:
                if (!mButtonClicked6) {
                    mButton6.setText(setText);
                    mButton6.setEnabled(false);
                    mButtonClicked6 = true;
                    checkWin();
                    returnVal = 1;
                } else {
                    returnVal = -1;
                }
                break;
            default:
                returnVal = -1;
                break;


        }
        return returnVal;

    }

    public void checkWin() {
        if (mButton.getText() == "O" && mButton4.getText() == "O" && mButton7.getText() == "O"
                || mButton.getText() == "X" && mButton4.getText() == "X" && mButton7.getText() == "X"

                || mButton.getText() == "O" && mButton2.getText() == "O" && mButton3.getText() == "O"
                || mButton.getText() == "X" && mButton2.getText() == "X" && mButton3.getText() == "X"

                || mButton.getText() == "O" && mButton5.getText() == "O" && mButton9.getText() == "O"
                || mButton.getText() == "X" && mButton5.getText() == "X" && mButton9.getText() == "X"

                || mButton4.getText() == "O" && mButton5.getText() == "O" && mButton6.getText() == "O"
                || mButton4.getText() == "X" && mButton5.getText() == "X" && mButton6.getText() == "X"

                || mButton7.getText() == "O" && mButton8.getText() == "O" && mButton9.getText() == "O"
                || mButton7.getText() == "X" && mButton8.getText() == "X" && mButton9.getText() == "X"

                || mButton2.getText() == "O" && mButton5.getText() == "O" && mButton8.getText() == "O"
                || mButton2.getText() == "X" && mButton5.getText() == "X" && mButton8.getText() == "X"

                || mButton3.getText() == "O" && mButton6.getText() == "O" && mButton9.getText() == "O"
                || mButton3.getText() == "X" && mButton6.getText() == "X" && mButton9.getText() == "X"

                || mButton3.getText() == "O" && mButton5.getText() == "O" && mButton7.getText() == "O"
                || mButton3.getText() == "X" && mButton5.getText() == "X" && mButton7.getText() == "X") {
            win = true;
        }

        tie = false;

        if (win == false
                && mButtonClicked == true
                && mButtonClicked2 == true
                && mButtonClicked3 == true
                && mButtonClicked4 == true
                && mButtonClicked5 == true
                && mButtonClicked6 == true
                && mButtonClicked7 == true
                && mButtonClicked8 == true
                && mButtonClicked9 == true) {

            tie = true;
        }
    }
    public void resetGame() {
        mButton.setText(R.string.filler);
        mButton2.setText(R.string.filler);
        mButton3.setText(R.string.filler);
        mButton4.setText(R.string.filler);
        mButton5.setText(R.string.filler);
        mButton6.setText(R.string.filler);
        mButton7.setText(R.string.filler);
        mButton8.setText(R.string.filler);
        mButton9.setText(R.string.filler);

        mButtonClicked = false;
        mButtonClicked2 = false;
        mButtonClicked3 = false;
        mButtonClicked4 = false;
        mButtonClicked5 = false;
        mButtonClicked6 = false;
        mButtonClicked7 = false;
        mButtonClicked8 = false;
        mButtonClicked9 = false;


        String winner = "";

        if (tie == true) {
            ties++;
            mServerClient.setText("X wins: " + x_wins + " | O wins: " + o_wins + " | Ties: " + ties);
            Toast.makeText(ServerGameActivity.this, "It was a tie!",
                    Toast.LENGTH_SHORT).show();
            win = false;
            tie = false;
            x_turn = true;
        } else if (x_turn == false) {
            x_wins++;
            winner = "X";
            mScoreText.setText("X wins: " + x_wins + " | O wins: " + o_wins + " | Ties: " + ties);
            Toast.makeText(ServerGameActivity.this, winner + " wins!",
                    Toast.LENGTH_SHORT).show();
            win = false;
            x_turn = true;
        } else {
            o_wins++;
            winner = "O";
            mScoreText.setText("X wins: " + x_wins + " | O wins: " + o_wins + " | Ties: " + ties);
            Toast.makeText(ServerGameActivity.this, winner + " wins!",
                    Toast.LENGTH_SHORT).show();
            win = false;
            x_turn = true;
        }

    }

    public void startServer() {
        new Thread(new AcceptThread()).start();

    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(output.getText().length() > 1000){
                output.setText("");
            }
            output.append(msg.getData().getString("msg"));
            return true;
        }

    });

    public void mkmsg(String str) {
        //handler junk, because thread can't update screen!
        Message msg = new Message();
        Bundle b = new Bundle();
        b.putString("msg", str);
        msg.setData(b);
        handler.sendMessage(msg);
    }

    private class AcceptThread extends Thread {
        // The local server socket
        private final BluetoothServerSocket mmServerSocket;

        public AcceptThread() {
            BluetoothServerSocket tmp = null;
            // Create a new listening server socket
            try {
                tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
            } catch (IOException e) {
                mkmsg("Failed to start server\n");
            }
            mmServerSocket = tmp;
        }

        public void run() {
            mkmsg("waiting on accept");
            BluetoothSocket socket = null;
            try {
                // This is a blocking call and will only return on a
                // successful connection or an exception
                socket = mmServerSocket.accept();
            } catch (IOException e) {
                mkmsg("Failed to accept\n");
            }

            // If a connection was accepted
            if (socket != null) {
                mkmsg("Connection made\n");
                mkmsg("Remote device address: " + socket.getRemoteDevice().getAddress() + "\n");
                //Note this is copied from the TCPdemo code.
                try {
                    while (true) {
                        if (waiting) {
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String str;
                            while ((str = in.readLine()) == null) {
                                mkmsg("Waiting on message ...\n");
                            }

                            mkmsg("received a message:\n" + str + "\n");


                            if (str.compareTo(AGREE) == 0) {
                                waiting = false;
                            } else {
                                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                                mkmsg("Attempting to send message ...\n");
                                out.println(handleMessage(str));
                                out.flush();
                                mkmsg("Message sent...\n");
                            }
                        } else {
                            if (win == true) {
                                currentMessage = PLAYAGAIN;
                            }

                            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                            mkmsg("Attempting to send message ...\n");
                            out.println(currentMessage);
                            out.flush();
                            mkmsg("Message sent...\n");
                            currentMessage = null;
                            waiting = true;
                        }
                    }
                    //mkmsg("We are done, closing connection\n");
                } catch (Exception e) {
                    mkmsg("Error happened sending/receiving\n");

                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        mkmsg("Unable to close socket" + e.getMessage() + "\n");
                    }
                }
            } else {
                mkmsg("Made connection, but socket is null\n");
            }
            mkmsg("Server ending \n");
        }

        public void cancel() {
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                mkmsg( "close() of connect socket failed: "+e.getMessage() +"\n");
            }
        }
    }
}