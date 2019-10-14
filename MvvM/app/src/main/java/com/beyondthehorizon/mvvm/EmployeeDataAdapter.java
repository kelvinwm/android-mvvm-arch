package com.beyondthehorizon.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.beyondthehorizon.mvvm.databinding.EmployeeItemBinding;

import java.util.ArrayList;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> employees;

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EmployeeItemBinding employeeItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.employee_item, parent, false);
        return new EmployeeViewHolder(employeeItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.employeeItemBinding.setEmployee(employee);
    }

    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }
    public void setEmployeeList(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {

        EmployeeItemBinding employeeItemBinding;

        public EmployeeViewHolder(@NonNull EmployeeItemBinding itemView) {
            super(itemView.getRoot());
            employeeItemBinding = itemView;
        }
    }
}
