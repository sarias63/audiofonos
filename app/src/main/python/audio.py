from java import youtube_dl

def main(plain_text_input):

    input_url=String(plain_text_input)

    #obtenemos el titulo del video
    video_info = youtube_dl.YoutubeDL().extract_info(url=input_url, download=False)
    video_title = video_info ['title']

    #Setear las opciones de para la descarga del video
    opciones = {
        'format':'bestaudio/best',
        'outtmpl':f"Music/{video_title}.mp3",#seteamos la ubicacion deseada
        'postprocessors': [{
            'key':'FFmpegExtractAudio',
            'preferredcodec':'mp3',
            'preferredquality':'192',
        }],
    }
    #descargar video
    with youtube_dl.YoutubeDL(opciones) as ydl:
        ydl.download([input_url])

