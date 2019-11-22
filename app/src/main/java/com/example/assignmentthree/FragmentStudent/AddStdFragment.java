package com.example.assignmentthree.FragmentStudent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignmentthree.MainActivity;
import com.example.assignmentthree.Model.Student;
import com.example.assignmentthree.R;

import java.util.ArrayList;
import java.util.List;

public class AddStdFragment  extends Fragment {

    public static List<Student> studentsList = new ArrayList<>();
    //List<Students> studentsList;
    private EditText etStudentName, etStudentAge,etStudentAddress;
    private RadioGroup Gender;
    private RadioButton rbtnMale,rbtnFemale,rbtnOther;
    private Button Register;
    private int Image, age;
    private String name, address, gender;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.add_student,container,false);
        etStudentName=view.findViewById(R.id.ET_FullName);
        etStudentAge=view.findViewById(R.id.ET_Age);
        etStudentAddress = view.findViewById(R.id.ET_Address);
        Gender = view.findViewById(R.id.RG_Gender);
        rbtnMale = view.findViewById(R.id.Rbtn_Male);
        rbtnFemale = view.findViewById(R.id.Rbtn_Female);
        rbtnOther = view.findViewById(R.id.Rbtn_Others);
        Register = view.findViewById(R.id.btnRegistration);

        final int[] image = {R.drawable.boy, R.drawable.girl, R.drawable.other};
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etStudentName.getText().toString();
                address = etStudentAddress.getText().toString();
                age = Integer.parseInt(etStudentAge.getText().toString());

                int selectGender = Gender.getCheckedRadioButtonId();
                RadioButton radioButton = view.findViewById(selectGender);
                gender = radioButton.getText().toString();
                if(gender.equals("Male")){
                    Image = image[0];
                }
                else if (gender.equals("Female")){
                    Image = image[1];
                }
                else
                {
                    Image = image[2];
                }

                Student students = new Student(name, address, gender, age, Image);
                studentsList = MainActivity.studentsList;
                studentsList.add(students);
                Toast.makeText(getActivity(),"Student registration successful",Toast.LENGTH_LONG).show();
                etStudentName.getText().clear();
                etStudentAddress.getText().clear();
                etStudentAge.getText().clear();
                Gender.clearCheck();
            }
        });
        return view;
    }
}
