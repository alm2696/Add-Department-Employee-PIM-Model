-- Create the 'departments' table
CREATE OR REPLACE TABLE departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,   -- Auto-incrementing primary key for department records
    department_name VARCHAR(50),                    -- Name of the department
    location VARCHAR(50)                            -- Location of the department
);

-- Insert records into the 'departments' table
INSERT INTO departments(department_name, location)
VALUES
    ('HR', 'New York'),                -- HR department located in New York
    ('Engineering', 'San Francisco'),  -- Engineering department located in San Francisco
    ('Marketing', 'Chicago'),          -- Marketing department located in Chicago
    ('Sales', 'Los Angeles'),          -- Sales department located in Los Angeles
    ('Finance', 'Austin');             -- Finance department located in Austin
