ALTER TABLE IF EXISTS t_users ALTER COLUMN first_name DROP NOT NULL;
ALTER TABLE IF EXISTS t_users ALTER COLUMN last_name DROP NOT NULL;
ALTER TABLE IF EXISTS t_users ALTER user_role_id DROP NOT NULL;
ALTER TABLE IF EXISTS t_users ALTER COLUMN user_role_id SET DEFAULT 4;