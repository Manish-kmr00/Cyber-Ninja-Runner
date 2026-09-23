Add-Type -AssemblyName System.Drawing
Get-ChildItem 'store_screenshots/0*.png' | ForEach-Object {
    $img = [System.Drawing.Image]::FromFile($_.FullName)
    $ratio = [Math]::Round($img.Width / $img.Height, 2)
    [PSCustomObject]@{
        Filename    = $_.Name
        Width       = $img.Width
        Height      = $img.Height
        AspectRatio = "$($img.Width):$($img.Height) (~$ratio:1)"
        SizeBytes   = $_.Length
        SizeKB      = [Math]::Round($_.Length / 1024, 1)
    }
    $img.Dispose()
} | Format-Table -AutoSize

