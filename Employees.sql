-- Create the 'employees' table
CREATE OR REPLACE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,  -- Auto-incrementing primary key for employee records
    first_name VARCHAR(30),                      -- First name of the employee
    last_name VARCHAR(30),                       -- Last name of the employee
    department_id INT,                           -- Foreign key reference to the 'departments' table
    salary INT,                                  -- Salary of the employee
    
    -- Foreign key constraint linking the 'department_id' to the 'departments' table
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

-- Insert records into the 'employees' table
INSERT INTO employees(first_name, last_name, department_id, salary)
VALUES
    ('John', 'Richards', 1, 60000),  -- John Richards, department 1, salary of 60,000
    ('Jane', 'Simons', 2, 75000),    -- Jane Simons, department 2, salary of 75,000
    ('Alice', 'Smith', 3, 50000),    -- Alice Smith, department 3, salary of 50,000
    ('Bob', 'Williams', 4, 80000),   -- Bob Williams, department 4, salary of 80,000
    ('Charlie', 'Davis', 5, 65000);  -- Charlie Davis, department 5, salary of 65,000

-- Add a foreign key constraint to the 'employees' table linking 'department_id' to 'departments'
ALTER TABLE employees 
ADD CONSTRAINT fk_department 
FOREIGN KEY (department_id) 
REFERENCES departments(department_id);
