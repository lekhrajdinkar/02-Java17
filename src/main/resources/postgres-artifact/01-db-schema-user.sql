CREATE DATABASE retailappdb;
-- \c retailappdb;
CREATE SCHEMA retailapp;

-- ====================================
-- Create user : manisha_r
-- ====================================
CREATE USER manisha_r WITH PASSWORD 'manisha#21';
-- Grants
GRANT CONNECT ON DATABASE retailappdb TO manisha_r;
GRANT USAGE ON SCHEMA retailapp TO manisha_r;
GRANT SELECT ON ALL TABLES IN SCHEMA retailapp TO manisha_r;
-- To ensure future tables are accessible
ALTER DEFAULT PRIVILEGES IN SCHEMA retailapp GRANT SELECT ON TABLES TO manisha_r;

-- ====================================
-- Create user : manisha_rwx
-- ====================================
CREATE USER manisha_rwx WITH PASSWORD 'manisha#21';
-- Grants
GRANT CONNECT ON DATABASE retailappdb TO manisha_rwx;
GRANT ALL PRIVILEGES ON SCHEMA retailapp TO manisha_rwx;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA retailapp TO manisha_rwx;
-- To ensure future tables are accessible
ALTER DEFAULT PRIVILEGES IN SCHEMA retailapp GRANT ALL PRIVILEGES ON TABLES TO manisha_rwx;