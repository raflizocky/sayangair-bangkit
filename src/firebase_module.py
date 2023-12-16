
# import firebase_admin
# from firebase_admin import credentials

# cred = credentials.Certificate('sayang-air-be45f-firebase-adminsdk-lt8tb-c133e13118.json')
# # default_app = firebase_admin.initialize_app(cred, {
# #     'databaseURL': "https://sayang-air-be45f-default-rtdb.asia-southeast1.firebasedatabase.app"
# # })


# firebase_admin.initialize_app(cred)

# from firebase_admin import db

# # Reference to the root of your Realtime Database
# root_ref = db.reference()

# # Example: Push data to the database
# new_data_ref = root_ref.child('data').push({'name': 'John', 'age': 25})

# # Example: Read data from the database
# snapshot = root_ref.child('data').get()
# print(snapshot.val())


import firebase_admin
from firebase_admin import credentials

# Path to the downloaded Firebase Admin SDK JSON file
cred = credentials.Certificate("sayang-air.json")

# Initialize the Firebase Admin SDK
default_app = firebase_admin.initialize_app(cred, {
    'databaseURL': 'https://sayang-air-be45f-default-rtdb.asia-southeast1.firebasedatabase.app/'
})


# Now you can interact with Firebase services using the SDK

from firebase_admin import db

# Reference to the root of your Realtime Database
root_ref = db.reference()

def postUsers(email, nik):
    # test
    # Example: Push data to the database
    new_data_ref = root_ref.child('users').push({'email': email, 'nik': nik})
    # Example: Read data from the database
    snapshot = root_ref.child('users').get()
    return snapshot