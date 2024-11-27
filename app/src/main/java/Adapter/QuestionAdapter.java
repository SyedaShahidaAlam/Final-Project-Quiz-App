package Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalprojectquizapp.DatabaseHelper;
import com.example.finalprojectquizapp.R;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private Context context;
    private Cursor cursor;
    private OnItemClickListener listener;

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Set the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Constructor for the adapter
    public QuestionAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom layout for each item
        View view = LayoutInflater.from(context).inflate(R.layout.question_view_custom, parent, false);
        return new QuestionViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            // Get data from the cursor
            String question = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_QUESTION_TEXT));
            int questionId = position + 1;

            // Set data to the views
            holder.questionTextView.setText(question);
            holder.questionIdTextView.setText("Q" + questionId);
        }
    }

    @Override
    public int getItemCount() {
        return cursor == null ? 0 : cursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        notifyDataSetChanged();
    }

    // ViewHolder class
    static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView, questionIdTextView;

        public QuestionViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.tv_question);
            questionIdTextView = itemView.findViewById(R.id.tv_question_number);

            // Set click listener for the entire item
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
