package com.example.resttemplateexp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateExperiments {

    private RestTemplate client = new RestTemplate();
    private String baseEmployeeUrl = "http://localhost:8585/employees";
    private String baseDepartmentsUrl = "http://localhost:8585/departments";


    public void fireRequests() {
        AddDepartmentRequest request = new AddDepartmentRequest();
        request.setDeptName("dev");
        DepartmentDetailsResponse departmentDetails = addDepartment(request);
        long deptId = departmentDetails.getId();
        AddEmployeeRequestDto requestDto = new AddEmployeeRequestDto();
        requestDto.setAge(27);
        requestDto.setDeptId(deptId);
        requestDto.setName("piyush");

        EmployeeResponseDto empDetails1 = addEmployee1(requestDto);

        EmployeeResponseDto empDetails2 = addEmployee2(requestDto);

        EmployeeResponseDto empDetails3 = addEmployee3(requestDto);

        EmployeeResponseDto foundEmp1 = fetchEmployeeById1(empDetails1.getId());
        EmployeeResponseDto foundEmp2 = fetchEmployeeById2(empDetails2.getId());
        EmployeeResponseDto foundEmp3 = fetchEmployeeById1(empDetails3.getId());

    }


    public EmployeeResponseDto fetchEmployeeById1(long id) {
        System.out.println("****inside fetchEmployeeById2");
        String url = baseEmployeeUrl + "/byid/" + id;
        EmployeeResponseDto details = client.getForObject(url, EmployeeResponseDto.class);
        display(details);
        return details;
    }

    public EmployeeResponseDto fetchEmployeeById2(long id) {
        System.out.println("******inside fetchEmployeeById2");
        String url = baseEmployeeUrl + "/byid/" + id;
        ResponseEntity<EmployeeResponseDto> responseEntity = client.getForEntity(url, EmployeeResponseDto.class);
        System.out.println("http status=" + responseEntity.getStatusCodeValue());
        EmployeeResponseDto responseBody = responseEntity.getBody();
        display(responseBody);
        return responseBody;
    }

    public DepartmentDetailsResponse addDepartment(AddDepartmentRequest request) {
        String url = baseDepartmentsUrl + "/add";
        DepartmentDetailsResponse response = client.postForObject(url, request, DepartmentDetailsResponse.class);
        return response;
    }

    public EmployeeResponseDto addEmployee1(AddEmployeeRequestDto request) {
        System.out.println("*****inside addEmployee1");
        String url = baseEmployeeUrl + "/add";
        EmployeeResponseDto response = client.postForObject(url, request, EmployeeResponseDto.class);
        display(response);
        return response;
    }


    public EmployeeResponseDto addEmployee2(AddEmployeeRequestDto request) {
        System.out.println("******inside addEmployee2");
        String url = baseEmployeeUrl + "/add";
        ResponseEntity<EmployeeResponseDto> responseEntity = client.postForEntity(url, request, EmployeeResponseDto.class);
        EmployeeResponseDto responseBody = responseEntity.getBody();
        System.out.println("resposne status=" + responseEntity.getStatusCodeValue());
        display(responseBody);
        return responseBody;
    }

    public EmployeeResponseDto addEmployee3(AddEmployeeRequestDto request) {
        System.out.println("*******inside addEmployee3");
        String url = baseEmployeeUrl + "/add";
        HttpEntity requestEntity = new HttpEntity(request);
        ResponseEntity<EmployeeResponseDto> responseEntity = client.exchange(url, HttpMethod.POST, requestEntity, EmployeeResponseDto.class);
        EmployeeResponseDto responseBody = responseEntity.getBody();
        System.out.println("resposne status=" + responseEntity.getStatusCodeValue());
        display(responseBody);
        return responseBody;
    }


    void display(EmployeeResponseDto details) {
        System.out.println("details=" + details.getId() + " " + details.getName() + " " + details.getAge());

    }


}
