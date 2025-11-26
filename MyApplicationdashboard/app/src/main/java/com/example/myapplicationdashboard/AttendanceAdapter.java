package com.example.myapplicationdashboard;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {

    private List<AttendanceRecord> attendanceList;

    public AttendanceAdapter(List<AttendanceRecord> attendanceList) {
        this.attendanceList = attendanceList;
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attendance, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        AttendanceRecord record = attendanceList.get(position);
        holder.subjectText.setText(record.getSubject());
        holder.presentText.setText("Present: " + record.getPresentDays());
        holder.absentText.setText("Absent: " + record.getAbsentDays());
        holder.percentageText.setText("Attendance: " + record.getPercentage() + "%");
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    static class AttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView subjectText, presentText, absentText, percentageText;

        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectText = itemView.findViewById(R.id.subjectText);
            presentText = itemView.findViewById(R.id.presentText);
            absentText = itemView.findViewById(R.id.absentText);
            percentageText = itemView.findViewById(R.id.percentageText);
        }
    }
}
