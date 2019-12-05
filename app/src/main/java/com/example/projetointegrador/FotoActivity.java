package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projetointegrador.model.Fotos;
import com.example.projetointegrador.model.Geral;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class FotoActivity extends AppCompatActivity {
  private ImageView imagem1,
                    imagem2,
                    imagem3,
                    imagem4;

  private final int GALERIA_IMAGENS = 1;
  private final int PERMISSAO_REQUEST = 2;

  List<String> imagesEncodedList;
  String imageEncoded;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_foto);

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
      if (ActivityCompat.shouldShowRequestPermissionRationale(this,
              Manifest.permission.READ_EXTERNAL_STORAGE)) {
      } else {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSAO_REQUEST);
      }
    }

    imagem1 = findViewById(R.id.image1);
    imagem2 = findViewById(R.id.image2);
    imagem3 = findViewById(R.id.image3);
    imagem4 = findViewById(R.id.image4);


    Button addFoto = findViewById(R.id.btnAddFoto);
    addFoto.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),GALERIA_IMAGENS);
      }
    });

    Button finalizar = findViewById(R.id.btnFinalizar);
    finalizar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Geral geral = (Geral) getIntent().getSerializableExtra("geral");

        Gson gson = new Gson();
        String gsonString = gson.toJson(geral);
        Intent intent = new Intent(FotoActivity.this, AnuncioActivity.class);
        startActivity(intent);
        //charmar api p salvar

        //ir para tela do anuncio
      }
    });


  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    try {
      // When an Image is picked
      if (requestCode == GALERIA_IMAGENS && resultCode == RESULT_OK  && null != data) {
        // Get the Image from data

        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        imagesEncodedList = new ArrayList<String>();
        if(data.getData()!=null){

          Uri mImageUri=data.getData();

          // Get the cursor
          Cursor cursor = getContentResolver().query(mImageUri,
                  filePathColumn, null, null, null);
          // Move to first row
          cursor.moveToFirst();

          int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
          imageEncoded  = cursor.getString(columnIndex);
          imagesEncodedList.add(imageEncoded);
          cursor.close();

        } else {
          if (data.getClipData() != null) {
            ClipData mClipData = data.getClipData();
            ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
            for (int i = 0; i < mClipData.getItemCount(); i++) {

              ClipData.Item item = mClipData.getItemAt(i);
              Uri uri = item.getUri();
              mArrayUri.add(uri);
              // Get the cursor
              Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
              // Move to first row
              cursor.moveToFirst();

              int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
              imageEncoded  = cursor.getString(columnIndex);
              imagesEncodedList.add(imageEncoded);
              cursor.close();


            }
            Log.v("LOG_TAG", "Selected Images" + mArrayUri.size());
          }
        }
      } else {
        Toast.makeText(this, "You haven't picked Image",
                Toast.LENGTH_LONG).show();
      }

      if (!imagesEncodedList.isEmpty()) {
        for (int j = 0; j < imagesEncodedList.size(); j++) {
          Bitmap thumbnail = (BitmapFactory.decodeFile(imagesEncodedList.get(j)));
          if(imagem1.getDrawable() == null){
            imagem1.setImageBitmap(thumbnail);
          }
          else if(imagem2.getDrawable() == null){
            imagem2.setImageBitmap(thumbnail);
          }
          else if(imagem3.getDrawable() == null){
            imagem3.setImageBitmap(thumbnail);
          }
          else{
            imagem4.setImageBitmap(thumbnail);
          }

        }
      }
      Geral geral = (Geral) getIntent().getSerializableExtra("geral");
      geral = atualizaGeral(geral, imagesEncodedList);

    } catch (Exception e) {
      Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
              .show();
    }

    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode,
                                         String permissions[], int[] grantResults) {
    if (requestCode == PERMISSAO_REQUEST) {
      if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        // A permissão foi concedida. Pode continuar
      } else {
        // A permissão foi negada. Precisa ver o que deve ser desabilitado
      }
      return;
    }
  }

  private Geral atualizaGeral(Geral geral, List<String> links) {

    List<Fotos> list = new ArrayList<>();
    try {
      for (int i =0; i < links.size(); i++) {
        Fotos foto = new Fotos();
        File teste = new File(links.get(i));
        byte[] imagem = Files.readAllBytes(Paths.get(teste.getAbsolutePath()));
        foto.setImagem(imagem);
        list.add(foto);
      }
      geral.setFotos(list);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return geral;
  }
}
