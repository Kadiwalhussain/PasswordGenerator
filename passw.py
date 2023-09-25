import random
import string

LOWER_CASE = string.ascii_lowercase
UPPER_CASE = string.ascii_uppercase
DIGITS = string.digits
SYMBOLS = "!@#$%^&*()|;:{}[]/.,?<>"
ALL_CHARACTERS = LOWER_CASE + UPPER_CASE + DIGITS + SYMBOLS

def generate_password(length):
    if length < 4:
        raise ValueError("Password length must be at least 4.")

    password = []
    password.append(random.choice(LOWER_CASE))
    password.append(random.choice(UPPER_CASE))
    password.append(random.choice(DIGITS))
    password.append(random.choice(SYMBOLS))

    available_characters = ALL_CHARACTERS
    available_characters = available_characters.replace(password[0], ' ')
    available_characters = available_characters.replace(password[1], ' ')
    available_characters = available_characters.replace(password[2], ' ')
    available_characters = available_characters.replace(password[3], ' ')

    for i in range(4, length):
        password.append(random.choice(available_characters))

    random.shuffle(password)
    return ''.join(password)

if __name__ == "__main__":
    password_length = 12
    generated_password = generate_password(password_length)
    print("Generated Password:", generated_password)
# add password