def factorial(n):
    # n! can also be defined as n * (n-1)!
    """ calculates n! recursively """
    if n <= 1:
        return 1
    else:
        return n * factorial(n-1)

#checking exceptions to prevent the failure of programs
try:
    print(factorial(900))
except (RecursionError, OverflowError):
    print("This program cannot calculate factorials that large")

print("Program terminating")

