package com.example.quizapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.R;
import com.example.quizapplication.model.Question;
import com.example.quizapplication.model.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionsFragment extends Fragment {

    private TextView tvQuestion;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioGroup radioGroup;
    List<String> answers;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuestionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionsFragment newInstance(String param1, String param2) {
        QuestionsFragment fragment = new QuestionsFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
        List<Question> questions = QuestionService.getQuestions();
        tvQuestion.setText(questions.get(0).getTitle());
        rb1.setText(questions.get(0).getOption().get(0));
        rb2.setText(questions.get(0).getOption().get(1));
        rb3.setText(questions.get(0).getOption().get(2));
        rb4.setText(questions.get(0).getOption().get(3));

        if(QuestionService.COUNTER == questions.size()-1)
        {
            QuestionService.COUNTER ++;
        }

        try{

        }
        catch (Exception e)
        {

        }

        Button btNext = view.findViewById(R.id.btNextQuestion);

        btNext.setOnClickListener(v -> {
            try{
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(radioButtonID);
                answers.add((String) radioButton.getText());
                Log.d("Answer", "onViewCreated: " + answers.get(QuestionService.COUNTER));
                Toast.makeText(this.getContext(), "Answer: " + answers.get(QuestionService.COUNTER), Toast.LENGTH_LONG).show();
                tvQuestion.setText(questions.get(QuestionService.COUNTER).getTitle());
                rb1.setText(questions.get(QuestionService.COUNTER).getOption().get(0));
                rb2.setText(questions.get(QuestionService.COUNTER).getOption().get(1));
                rb3.setText(questions.get(QuestionService.COUNTER).getOption().get(2));
                rb4.setText(questions.get(QuestionService.COUNTER).getOption().get(3));
                //answers.add((String) radioButton.getText());
                if(QuestionService.COUNTER == questions.size()){
                    //Toast.makeText(this.getContext(), "Launching results!" + answers.get(QuestionService.COUNTER), Toast.LENGTH_SHORT).show();
                    launchFragment(new Results());
                }
            QuestionService.COUNTER ++;
            }
            catch (Exception e)
            {

            }
        });
    }

    public void launchFragment(Fragment fragment){
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Q1", (ArrayList<String>) answers);
        fragment.setArguments(bundle);
        this.requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null);
    }

    public void initialize(View view){
        answers = new ArrayList<>();
        tvQuestion = view.findViewById(R.id.tvQuestion);
        radioGroup = view.findViewById(R.id.rgQuestion);
        rb1 = view.findViewById(R.id.rb1);
        rb2 = view.findViewById(R.id.rb2);
        rb3 = view.findViewById(R.id.rb3);
        rb4 = view.findViewById(R.id.rb4);
    }
}