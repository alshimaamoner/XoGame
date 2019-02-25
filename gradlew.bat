<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity" android:orientation="vertical">
<TextView android:text="Player1: 0" android:id="@+id/player1"
    android:textSize="30sp" app:layout_constraintTop_toTopOf="parent" app:layout_constraintStart_toEndOf="parent"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" android:textColor="@android:color/holo_blue_dark"/>

    <TextView
        android:id="@+id/player2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/player1"
        android:text="Player2: 0"
        android:textColor="@android:color/holo_blue_dark"
        android:textSize="30sp"
         />

    <Button android:id="@+id/reset"
        android:layout_width="wrap_content" android:textColor="@android:color/holo_blue_dark"
        android:layout_height="wrap_content" android:text="Reset"
        app:layout_constraintEnd_toEndOf="parent"/>

    <LinearLayout android:id="@+id/layout1"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:weightSum="100"
        app:layout_constraintTop_toBottomOf="@id/player2"
        tools:ignore="MissingConstraints" android:gravity="center"
        >

        <Button
            android:id="@+id/btn0"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="25"
            android:textColor="@android:color/holo_blue_dark"
            android:textSize="60sp"
            />

        <Button
            android:id="@+id/btn1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="25"
            android:textColor="@android:color/holo_blue_dark"
            android:textSize="60sp"
            />
        <Button
            android:id="@+id