count = int(input("출석 번호를 부른 횟수 입력: "))
call = list(map(int, input("학생의 출석 번호를 입력: ").split(" ")))

students = [0 for i in range(23)]

for i in range(count):
    students[call[i]-1] = students[call[i]-1] + 1
    i = i + 1

print(students)
