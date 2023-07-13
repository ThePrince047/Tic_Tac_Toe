package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //9 zero
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{0, 4, 8});
        combinationList.add(new int[]{1, 6, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});

        String p1name = getIntent().getStringExtra("p1");
        String p2name = getIntent().getStringExtra("p2");

        binding.p1name.setText(p1name);
        binding.p2name.setText(p2name);

        binding.i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0)) {
                    performAction((ImageView) view, 0);
                }
            }
        });
        binding.i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(1)) {
                    performAction((ImageView) view, 1);
                }
            }
        });
        binding.i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2)) {
                    performAction((ImageView) view, 2);
                }
            }
        });
        binding.i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3)) {
                    performAction((ImageView) view, 3);
                }
            }
        });
        binding.i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4)) {
                    performAction((ImageView) view, 4);
                }
            }
        });
        binding.i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5)) {
                    performAction((ImageView) view, 5);
                }
            }
        });
        binding.i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6)) {
                    performAction((ImageView) view, 6);
                }
            }
        });
        binding.i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7)) {
                    performAction((ImageView) view, 7);
                }
            }
        });
        binding.i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8)) {
                    performAction((ImageView) view, 8);
                }
            }
        });
    }


        public void performAction (ImageView imageView,int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = playerTurn;
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage);
            if (checkResults()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.p1name.getText().toString()
                        + " is a Winner!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if (totalSelectedBoxes == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.oimage);
            if (checkResults()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.p2name.getText().toString()
                        + " is a Winner!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if (totalSelectedBoxes == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

        public void changePlayerTurn ( int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            binding.p1layout.setBackgroundResource(R.drawable.black_border);
            binding.p2layout.setBackgroundResource(R.drawable.white_box);
        } else if(playerTurn==2) {
            binding.p2layout.setBackgroundResource(R.drawable.black_border);
            binding.p1layout.setBackgroundResource(R.drawable.white_box);
        }
    }

        public boolean checkResults () {
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final int[] combination = combinationList.get(i);

            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }

        public boolean isBoxSelectable ( int boxPosition){
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

        public void restartMatch () {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}; //9 zero
        playerTurn = 1;
        totalSelectedBoxes = 1;

        binding.i1.setImageResource(R.drawable.white_box);
        binding.i2.setImageResource(R.drawable.white_box);
        binding.i3.setImageResource(R.drawable.white_box);
        binding.i4.setImageResource(R.drawable.white_box);
        binding.i5.setImageResource(R.drawable.white_box);
        binding.i6.setImageResource(R.drawable.white_box);
        binding.i7.setImageResource(R.drawable.white_box);
        binding.i8.setImageResource(R.drawable.white_box);
        binding.i9.setImageResource(R.drawable.white_box);
    }
}