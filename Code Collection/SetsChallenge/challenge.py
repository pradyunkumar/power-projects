# A program that takes some text and returns a list of
# all the characters in the text that are not vowels, sorted in
# alphabetical order.

sampleText = "Python is a very powerful language"

vowels = frozenset("aeiou")
# vowels = {"a", "e", "i", "o", "u"}
finalSet = set(sampleText).difference(vowels)
print(finalSet)

finalList = sorted(finalSet)
print(finalList)