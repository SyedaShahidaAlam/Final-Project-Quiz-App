package Adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import Database.DatabaseHelper;
import com.example.finalprojectquizapp.R;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private Context context;
    private Cursor cursor;
    private boolean isSubmitted; // Track if the answers should be revealed
    private SparseBooleanArray correctAnswers = new SparseBooleanArray(); // Store if each question is answered correctly

    public QuestionAdapter(Context context, Cursor cursor, boolean isSubmitted) {
        this.context = context;
        this.cursor = cursor;
        this.isSubmitted = isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        this.isSubmitted = submitted;
        notifyDataSetChanged(); // Update UI
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ans_list_custom, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            // Get data from the cursor
            String question = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_QUESTION_TEXT));
            String option1 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_OPTION1));
            String option2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_OPTION2));
            String option3 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_OPTION3));
            String option4 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_OPTION4));
            String correctAnswer = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ANSWER));

            int questionId = position + 1;

            // Set data to the views
            holder.questionTextView.setText(question);
            holder.questionIdTextView.setText(String.valueOf(questionId));
            holder.rbOption1.setText(option1);
            holder.rbOption2.setText(option2);
            holder.rbOption3.setText(option3);
            holder.rbOption4.setText(option4);

            // Show the correct answer if submitted
            if (isSubmitted) {
                holder.answerTextView.setText("Correct answer: " + correctAnswer);
            } else {
                holder.answerTextView.setText(""); // Clear the answer text
            }

            // Restore selection state
            holder.radioGroupOptions.clearCheck();
            if (correctAnswers.get(position, false)) {
                if (correctAnswer.equals(option1)) holder.rbOption1.setChecked(true);
                else if (correctAnswer.equals(option2)) holder.rbOption2.setChecked(true);
                else if (correctAnswer.equals(option3)) holder.rbOption3.setChecked(true);
                else if (correctAnswer.equals(option4)) holder.rbOption4.setChecked(true);
            }

            // Handle radio button selection
            holder.radioGroupOptions.setOnCheckedChangeListener((group, checkedId) -> {
                boolean isCorrect = false;
                if (checkedId == R.id.rb_option1 && correctAnswer.equals(option1)) isCorrect = true;
                else if (checkedId == R.id.rb_option2 && correctAnswer.equals(option2)) isCorrect = true;
                else if (checkedId == R.id.rb_option3 && correctAnswer.equals(option3)) isCorrect = true;
                else if (checkedId == R.id.rb_option4 && correctAnswer.equals(option4)) isCorrect = true;

                correctAnswers.put(position, isCorrect); // Save correctness
            });
        }
    }

    @Override
    public int getItemCount() {
        return cursor == null ? 0 : cursor.getCount();
    }

    public SparseBooleanArray getCorrectAnswers() {
        return correctAnswers;
    }

    static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView, questionIdTextView, answerTextView;
        RadioButton rbOption1, rbOption2, rbOption3, rbOption4;
        RadioGroup radioGroupOptions;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);

            questionTextView = itemView.findViewById(R.id.tv_question);
            questionIdTextView = itemView.findViewById(R.id.tv_question_number);
            rbOption1 = itemView.findViewById(R.id.rb_option1);
            rbOption2 = itemView.findViewById(R.id.rb_option2);
            rbOption3 = itemView.findViewById(R.id.rb_option3);
            rbOption4 = itemView.findViewById(R.id.rb_option4);
            radioGroupOptions = itemView.findViewById(R.id.radioGroupOptions);
            answerTextView = itemView.findViewById(R.id.tv_answer);
        }
    }
}
